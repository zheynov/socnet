//Beginning of plugin

(function ($) {
    $.fn.page = function (PageSize) {
        $(this).addClass("page-table")
        var tableId = $(this).attr("id");

        //if id is not defined for table. Do Nothing.
        if (typeof tableId == 'undefined') {
            return this;
        };

        //Check for controls for this table and remove
        $('.pagination[for="' + tableId + '"]').remove();

        //Check for valid variable for pageSize if not set to default of 10
        if (typeof PageSize == 'number') {
            PageSize = parseInt(PageSize);
        } else if (typeof PageSize == 'string') {
            if ($.isNumeric(PageSize) == true) {
                PageSize = parseInt(PageSize);
            } else {
                PageSize = 10;
            }
        } else {
            PageSize = 10;
        }

        //Add pagination <ul> to hold controls
        $(this).after('<ul class="pagination" for="' + tableId + '"></ul>');

        //Add a pager control for each page
        var currpage = 1;
        var item = 1;
        $(this).find('tr:has(td)').each(function () {

            $(this).attr('data-page', currpage);

            if ((item % PageSize) == 0) {
                currpage = currpage + 1;
                $('.pagination[for="' + tableId + '"]').append('<li><a href="#" data-page="' + currpage + '" for="' + tableId + '">' + currpage + '</a></li>')
            } else if (item == 1) {
                $('.pagination[for="' + tableId + '"]').append('<li><a href="#" class="active" data-page="' + currpage + '" for="' + tableId + '">' + currpage + '</a></li>')
            }
            item = item + 1;
        });

        //load 1st page
        pageNumber(1, tableId);
        $(this).next('.pagination[for="' + tableId + '"]').find('a').on('click', function (e) {
            e.preventDefault();
            pageNumber($(this).attr('data-page'), this);
        });
        return this;
    }

    // Private function page change
    function pageNumber(iPage, element) {
        if (typeof element == 'string') {
            var target = element;
        } else {
            var target = $(element).attr("for");
        }


        if (typeof target == 'undefined') {
            $('.page-table tr:has(td)').hide();
            $('.page-table tr[data-page="' + iPage + '"]').show();
        } else {
            $('#' + target + ' tr:has(td)').hide();
            $('#' + target + ' tr[data-page="' + iPage + '"]').show();
        }
    };

})(jQuery);

//End of plugin Beginning of Initialization

//if no page size is passed default is 10. Below we are setting page size to 20
$('#friendsTable').page(20);

//Changes page size from select value
$('select[for="friendsTable"]').on('change', function () {
    $('#friendsTable').page($(this).val());
});