$("#add-form").submit( function(event){
         event.preventDefault();
         var data = {};
         $.each( $(this).serializeArray(), function(index, o){
                  data[o.name] = o.value
         })
         $.ajax({
                  url: "/ajaxtest/api/guestbook/insert",
                  type: "POST",
                  dataType: "json",
                  contentType: "application/json",
                  data: JSON.stringify(data),
                  success: function(result){
                  }
         })
});