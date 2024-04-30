$(document).ready(function() {
            $('#userForm').submit(function(event) {
                event.preventDefault();
                var formDataArray = $(this).serialize();
                $.ajax({
                    type: 'POST',
                    url: '/projects/nailSalon/clients/clientsAddClient/addClient',
                    data: formDataArray,
                    success: function(response) {
                        alert("User created succesfully");
                        window.location.href = "/projects/nailSalon/clients";
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
            });
        });