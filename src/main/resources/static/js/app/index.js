var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            alert('!');
            _this.save();
        });
    },
    save : function () {
        if ($('#title').val() == '') {
            alert('title empty');
            return;
        }
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/rest/v1/notice',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Notice is saved');
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    }
};

main.init();