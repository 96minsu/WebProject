    $('#btn1').on('click', function(){
        $.ajax({
            url: 'https://localhost:8080/test3,
            type: "POST",
            data: form,
            success: function(data){
                $('#result').text(data);
            },
            error: function(){
                alert("simpleWithObject err");
            }
        });
    });