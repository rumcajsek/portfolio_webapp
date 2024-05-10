$(document).ready(function() {
            $('#userForm').submit(function(event) {
                event.preventDefault();
                var formDataArray = $(this).serialize();
                $.ajax({
                    type: 'POST',
                    url: '/projects/nailSalon/clients/addClient',
                    data: formDataArray,
                    success: function(response) {
                        alert("User created succesfully");
                        window.location.href = "/projects/nailSalon/clients";
                    },
                    error: function(xhr, status, error) {
                        alert("Error while creating user! See console for details.")
                        console.error(xhr.responseText);
                    }
                });
            });
        });

function closeModal() {
    document.getElementById('addClientModal').style.display = 'none';
}