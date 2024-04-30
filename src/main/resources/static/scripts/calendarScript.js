document.addEventListener("DOMContentLoaded", function() {
    // Get current date
    const currentDate = new Date();

    // Get the tbody element where calendar cells will be populated
    const calendarBody = document.getElementById("calendar-body");

    // Function to populate the calendar with appointments
    function populateCalendar() {
        // Clear previous content
        calendarBody.innerHTML = '';

        // Loop through each day of the current month
        const daysInMonth = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0).getDate();
        for (let day = 1; day <= daysInMonth; day++) {
            // Create a new table row
            const row = document.createElement("tr");

            // Loop through each day of the week (7 days)
            for (let weekday = 0; weekday < 7; weekday++) {
                // Create a new table cell
                const cell = document.createElement("td");

                // Add the day number to the cell
                cell.textContent = day;

                // Create a div to hold appointments for the day
                const appointmentsDiv = document.createElement("div");
                appointmentsDiv.classList.add("appointments");

                // Create a dummy appointment for demonstration purposes
                const appointment = document.createElement("div");
                appointment.classList.add("appointment");
                appointment.textContent = "10:00 - Appointment Name";

                // Append the appointment to the appointments div
                appointmentsDiv.appendChild(appointment);

                // Append the appointments div to the cell
                cell.appendChild(appointmentsDiv);

                // Append the cell to the row
                row.appendChild(cell);

                // Increment day for the next iteration
                day++;
            }

            // Append the row to the calendar body
            calendarBody.appendChild(row);
        }
    }

    // Populate the calendar initially
    populateCalendar();
});