var list = "";
$(document).ready(function() {


    $.ajax({
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        url: "/rating/userList/"
    })
        .then(function(data) {
            for(i in data){
                list+= "<li>" + data[i].username  + "-->" +  data[i].rating+ "pts"+  "</li>";
            }
            $('.userList').append(list);


    });
});


function loadUser() {
    var username = $('input[name="username"]').val();


$.ajax({
        type: 'GET',
        dataType: 'json',
        data:{username: username},
        contentType: 'application/json; charset=utf-8',
        url: "/rating/getUser/",
        success:(function (data) {
            $('.userList').empty();
            $('.userList').append("<li>" + data.username  + "-->" +  data.rating+ "pts"+  "</li>");
            return false;
        }),
        error:(function () {
            $('.userList').empty();
            $('.userList').append(list);
        })
    });
};

$( function() {
    $('form').submit(function() {
        loadUser();
        return false;
    });
});
