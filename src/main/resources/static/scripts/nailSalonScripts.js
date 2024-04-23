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
//
//function serializeToCorrectJSON(formDataString) {
//    var pairs = formDataString.split('&');
//    // Initialize an empty object to store key-value pairs
//    var formDataJSON = {};
//
//    // Loop through each key-value pair
//    pairs.forEach(function(pair) {
//        // Split the pair into key and value
//        var keyValue = pair.split('=');
//        var key = decodeURIComponent(keyValue[0]); // Decode URL-encoded key
//        var value = decodeURIComponent(keyValue[1]); // Decode URL-encoded value
//        formDataJSON[key] = value; // Add key-value pair to formDataJSON object
//    });
//    return formDataJSON;
//}