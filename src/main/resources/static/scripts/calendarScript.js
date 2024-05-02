document.addEventListener("DOMContentLoaded", function() {
    // Attach click event listener to close button
    document.querySelector('.close').addEventListener('click', closeModal);

    // Attach click event listener to modal overlay to close modal
    document.getElementById('appointment-modal').addEventListener('click', function(event) {
        if (event.target === this) {
            closeModal();
        }
    });
});

// Function to open modal with detailed person info
function openModal(appointment) {
    const modal = document.getElementById('appointment-modal');
    const modalContent = document.getElementById('appointment-details');
    modalContent.innerHTML = `
        <p><strong>Name:</strong> ${appointment.name}</p>
        <p><strong>Surname:</strong> ${appointment.date.toLocalTime().toString()}</p>
    `;
    modal.style.display = 'block';
}

// Function to close the modal
function closeModal() {
    document.getElementById('appointment-modal').style.display = 'none';
}
