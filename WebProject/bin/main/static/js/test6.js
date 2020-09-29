   $('#btn4').on('click', function(){
        var form = {
                name: "jamong",
                age: 23
        }
        $.ajax({
            url: "test4",
            type: "POST",
            data: JSON.stringify(form),
            contentType: "application/json; charset=utf-8;",
            dataType: "json",
            success: function(data){
                for(var i=0; i<data.length; i++){
                    $('#result').append(data[i] + "<br>");
                }
            },
            error: function(){
                alert("restController err");
            }
        });
    });
    $("#joinOk").bind("click",function(){
        $.ajax({
            url : contextPath+"/ajax.seo",
            type: "get",
            data : { "id" : $("#id").val() },
            success : function(data){
                $("#ajax").remove();
                alert(data);
                if(!data){
                    alert("존재하지 않는 ID입니다");
                    return false;
                }
                var html = '';
                html += '<form class="form-signin" action="" id="ajax">';
                html += '이름<input type="text" class="form-control"  name="name" value="'+data.name+'">';
                html += '아이디<input type="text" class="form-control" name=id" value="'+data.id+'">';
                html += '이메일<input type="text" class="form-control"  name="email" value="'+data.email+'">';
                html += '비밀번호<input type="text" class="form-control" name="password" value="'+data.password+'">';
                html += '</form>';
                $("#container").after(html);
            }
        });

    });