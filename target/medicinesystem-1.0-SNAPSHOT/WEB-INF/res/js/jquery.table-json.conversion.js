(function($) {
	$.jsonToTable = function(data, options) {
		var settings = $.extend({
			id: null, // target element id
			header: true,
			className: null
		}, options);

		options = $.extend(settings, options);

		var obj = data;
		if (typeof obj === "string") {
			obj = $.parseJSON(obj);
		}

		if (options.id && obj.length) {

			var i, row;
			var table = $("<table></table>");

			if (options.className) {
				table.addClass(options.className);
			}

			$.fn.appendTr = function(rowData, isHeader) {
				var frameTag = isHeader ? "thead" : "tbody";
				var rowTag = isHeader ? "th" : "td";
				var rowi,key,cellObj,cell,j;

				/* if rowData is object, set the key and value as tr's properties */
				if ($.isPlainObject(rowData) && rowData._data) {
					row = '<tr';

					for (rowi in rowData) {
						if (rowi !== '_data') {
							row += ' ' + rowi + '="' + rowData[rowi] + '"';
						}
					}
					row += '></tr>';
					rowData = rowData._data;

				} else {
					row = "<tr></tr>";
				}

				row = $(row);

				for (key in rowData) {
					cellObj = rowData[key];

					if (typeof cellObj !== "function") { /* ADDED: this wrapper to account for people bootstrapping the ECMA Array model otherwise functions get converted to strings and show up in the object list / output */

						cell = '';

						/* if cellObj is object, set the key and value as cell's properties */
						if ($.isPlainObject(cellObj) && cellObj._data) {
							cell = "<" + rowTag;

							for (j in cellObj) {
								if (j !== '_data') {
									cell += ' ' + j + '="' + cellObj[j] + '"';
								}
							}

							cellObj = cellObj._data;

							cell += '>' + cellObj + "</" + rowTag + ">";

						} else {
							cell = "<" + rowTag + ">" + cellObj + "</" + rowTag + ">";
						}

						row.append(cell);
					}
				}

				if (isHeader) { /* ADDED: IF/ELSE to eliminate repetitive TBODY tags for every row */
					$(this).append($("<" + frameTag + "></" + frameTag + ">").append(row));

				} else {
					var tbody = $(this).find("tbody");
					if (tbody.length === 0) {
						tbody = $(this).append("<tbody></tbody>");
					}

					tbody.append(row); //always append data rows to the first tbody tag
				}

				return this;
			};
            
			$.fn.getJsonKey = function (rowData) {
                rowHade = {};
                for (var key in rowData)
                    rowHade[key] = key;
                return rowHade;
            };
			
			if (options.header) {
				//table.appendTr(obj[0], true);
                table.appendTr(table.getJsonKey(obj[0]), true);
			}

		/*	for (i = options.header ? 1 : 0; i < obj.length; i++) { /!* MODIFIED: options.header ? 1 : 0 --- to eliminate duplicating header as the first row of data *!/
				table.appendTr(obj[i], false, i);
			}*/
            for (i = 0; i < obj.length; i++) { /* MODIFIED: options.header ? 1 : 0 --- to eliminate duplicating header as the first row of data */
                table.appendTr(obj[i], false, i);
            }

			$(options.id).append(table);
		}

		return this;
	};
}(jQuery));

(function( $ ) {
  'use strict';

  $.fn.tableToJson = function(opts) {

    // Set options
    var defaults = {
      ignoreColumns: [],
      onlyColumns: null,
      ignoreHiddenRows: true,
      ignoreEmptyRows: false,
      headings: null,
      allowHTML: false,
      includeRowId: false,
      textDataOverride: 'data-override',
      textExtractor: null
    };
    opts = $.extend(defaults, opts);

    var notNull = function(value) {
      return value !== undefined && value !== null;
    };

    var ignoredColumn = function(index) {
      if( notNull(opts.onlyColumns) ) {
        return $.inArray(index, opts.onlyColumns) === -1;
      }
      return $.inArray(index, opts.ignoreColumns) !== -1;
    };

    var arraysToHash = function(keys, values) {
      var result = {}, index = 0;
      $.each(values, function(i, value) {
        // when ignoring columns, the header option still starts
        // with the first defined column
        if ( index < keys.length && notNull(value) ) {
          result[ keys[index] ] = value;
          index++;
        }
      });
      return result;
    };

    var cellValues = function(cellIndex, cell, isHeader) {
      var $cell = $(cell),
        // textExtractor
        extractor = opts.textExtractor,
        override = $cell.attr(opts.textDataOverride);
      // don't use extractor for header cells
      if ( extractor === null || isHeader ) {
        return $.trim( override || ( opts.allowHTML ? $cell.html() : cell.textContent || $cell.text() ) || '' );
      } else {
        // overall extractor function
        if ( $.isFunction(extractor) ) {
          return $.trim( override || extractor(cellIndex, $cell) );
        } else if ( typeof extractor === 'object' && $.isFunction( extractor[cellIndex] ) ) {
          return $.trim( override || extractor[cellIndex](cellIndex, $cell) );
        }
      }
      // fallback
      return $.trim( override || ( opts.allowHTML ? $cell.html() : cell.textContent || $cell.text() ) || '' );
    };

    var rowValues = function(row, isHeader) {
      var result = [];
      var includeRowId = opts.includeRowId;
      var useRowId = (typeof includeRowId === 'boolean') ? includeRowId : (typeof includeRowId === 'string') ? true : false;
      var rowIdName = (typeof includeRowId === 'string') === true ? includeRowId : 'rowId';
      if (useRowId) {
        if (typeof $(row).attr('id') === 'undefined') {
          result.push(rowIdName);
        }
      }
      $(row).children('td,th').each(function(cellIndex, cell) {
        result.push( cellValues(cellIndex, cell, isHeader) );
      });
      return result;
    };

    var getHeadings = function(table) {
      var firstRow = table.find('tr:first').first();
      return notNull(opts.headings) ? opts.headings : rowValues(firstRow, true);
    };

    var construct = function(table, headings) {
      var i, j, len, len2, txt, $row, $cell,
        tmpArray = [], cellIndex = 0, result = [];
      table.children('tbody,*').children('tr').each(function(rowIndex, row) {
        if( rowIndex > 0 || notNull(opts.headings) ) {
          var includeRowId = opts.includeRowId;
          var useRowId = (typeof includeRowId === 'boolean') ? includeRowId : (typeof includeRowId === 'string') ? true : false;

          $row = $(row);

          var isEmpty = ($row.find('td').length === $row.find('td:empty').length) ? true : false;

          if( ( $row.is(':visible') || !opts.ignoreHiddenRows ) && ( !isEmpty || !opts.ignoreEmptyRows ) && ( !$row.data('ignore') || $row.data('ignore') === 'false' ) ) {
            cellIndex = 0;
            if (!tmpArray[rowIndex]) {
              tmpArray[rowIndex] = [];
            }
            if (useRowId) {
              cellIndex = cellIndex + 1;
              if (typeof $row.attr('id') !== 'undefined') {
                tmpArray[rowIndex].push($row.attr('id'));
              } else {
                tmpArray[rowIndex].push('');
              }
            }

            $row.children().each(function(){
              $cell = $(this);
              // skip column if already defined
              while (tmpArray[rowIndex][cellIndex]) { cellIndex++; }

              // process rowspans
              if ($cell.filter('[rowspan]').length) {
                len = parseInt( $cell.attr('rowspan'), 10) - 1;
                txt = cellValues(cellIndex, $cell);
                for (i = 1; i <= len; i++) {
                  if (!tmpArray[rowIndex + i]) { tmpArray[rowIndex + i] = []; }
                  tmpArray[rowIndex + i][cellIndex] = txt;
                }
              }
              // process colspans
              if ($cell.filter('[colspan]').length) {
                len = parseInt( $cell.attr('colspan'), 10) - 1;
                txt = cellValues(cellIndex, $cell);
                for (i = 1; i <= len; i++) {
                  // cell has both col and row spans
                  if ($cell.filter('[rowspan]').length) {
                    len2 = parseInt( $cell.attr('rowspan'), 10);
                    for (j = 0; j < len2; j++) {
                      tmpArray[rowIndex + j][cellIndex + i] = txt;
                    }
                  } else {
                    tmpArray[rowIndex][cellIndex + i] = txt;
                  }
                }
              }

              txt = tmpArray[rowIndex][cellIndex] || cellValues(cellIndex, $cell);
              if (notNull(txt)) {
                tmpArray[rowIndex][cellIndex] = txt;
              }
              cellIndex++;
            });
          }
        }
      });
      $.each(tmpArray, function( i, row ){
        if (notNull(row)) {
          // remove ignoredColumns / add onlyColumns
          var newRow = notNull(opts.onlyColumns) || opts.ignoreColumns.length ?
            $.grep(row, function(v, index){ return !ignoredColumn(index); }) : row,

            // remove ignoredColumns / add onlyColumns if headings is not defined
            newHeadings = notNull(opts.headings) ? headings :
              $.grep(headings, function(v, index){ return !ignoredColumn(index); });

          txt = arraysToHash(newHeadings, newRow);
          result[result.length] = txt;
        }
      });
      return result;
    };

    // Run
    var headings = getHeadings(this);
    return construct(this, headings);
  };
})( jQuery );
