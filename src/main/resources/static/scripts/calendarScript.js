// document.addEventListener("DOMContentLoaded", function() {
//     // Attach click event listener to close button
//     document.querySelector('.close').addEventListener('click', closeModal);
//
//     // Attach click event listener to modal overlay to close modal
//     document.getElementById('appointment-modal').addEventListener('click', function(event) {
//         if (event.target === this) {
//             closeModal();
//         }
//     });
// });

function foo(bar) {
    alert('Inside foo(bar)');
    console.log(bar);
    console.log('after bar');
}

// Function to open modal with detailed person info
function openAppointmentModal(appointment) {
    event.stopPropagation();
    console.log(appointment);
    console.log(appointment.id);
    console.log(appointment.title);
    console.log(appointment.date);
    const modalContent = document.getElementById('appointment-details');
    modalContent.innerHTML = `
        <p><strong>Name:</strong> ${appointment.title}</p>
        <p><strong>Surname:</strong> ${appointment.date}</p>
    `;
    $('#appointmentModal').modal('show');
}

// Function to open modal with detailed person info
function openScheduleModal(day) {
    console.log(day);
    const modalContent = document.getElementById('schedule-appointment-details');
    modalContent.innerHTML = `
        <p><strong>Day:</strong> ${day}</p>
    `;
    $('#scheduleModal').modal('show');
}

// Function to close the modal
function closeAppointmentModal() {
    document.getElementById('appointmentModal').style.display = 'none';
}

// Function to close the modal
function closeScheduleModal() {
    document.getElementById('scheduleModal').style.display = 'none';
}
