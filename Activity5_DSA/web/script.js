// Global state to store records
let records = [];
let addPosition = 'last'; // 'first' or 'last'
// DOM Elements
const addModal = document.getElementById('addModal');
const editModal = document.getElementById('editModal');
const viewModal = document.getElementById('viewModal');
const recordDisplayModal = document.getElementById('recordDisplayModal');
const notification = document.getElementById('notification');
const recordsTable = document.getElementById('records-table');

// Form Elements
const addForm = document.getElementById('addForm');
const editForm = document.getElementById('editForm');
const viewForm = document.getElementById('viewForm');

// Event Listeners
document.addEventListener('DOMContentLoaded', () => {
    loadRecords();
});

addForm.addEventListener('submit', handleAdd);
editForm.addEventListener('submit', handleEdit);
viewForm.addEventListener('submit', handleView);

/**
 * Loads records from the text file.
 */
function loadRecords() {
    fetch('../records.txt')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(text => {
            records = text.trim().split('\n').filter(line => line).map(line => {
                const [name, age, gender] = line.split(',');
                return { name, age, gender };
            });
            displayRecords();
            showNotification('Records loaded successfully!', 'success');
        })
        .catch(error => {
            console.error('Error loading records:', error);
            showNotification('Error loading records.', 'error');
            displayRecords(); // Display empty state
        });
}

/**
 * Displays records in the table.
 */
function displayRecords() {
    recordsTable.innerHTML = '';
    if (records.length === 0) {
        recordsTable.innerHTML = `
            <div class="empty-state">
                <i class="fas fa-folder-open"></i>
                <h3>No Records Found</h3>
                <p>Add a new record to get started.</p>
            </div>
        `;
        return;
    }

    const table = document.createElement('table');
    table.innerHTML = `
        <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
            </tr>
        </thead>
        <tbody>
            ${records.map((record, index) => `
                <tr>
                    <td>${index + 1}</td>
                    <td>${record.name}</td>
                    <td>${record.age}</td>
                    <td>${record.gender}</td>
                </tr>
            `).join('')}
        </tbody>
    `;
    recordsTable.appendChild(table);
}

/**
 * Handles adding a new record.
 * @param {Event} e The form submission event.
 */
function handleAdd(e) {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const age = document.getElementById('age').value;
    const gender = document.getElementById('gender').value;
    const newRecord = { name, age, gender };

    if (addPosition === 'first') {
        records.unshift(newRecord);
    } else {
        records.push(newRecord);
    }

    saveRecords();
    closeModal('addModal');
    addForm.reset();
}

/**
 * Handles editing a record.
 * @param {Event} e The form submission event.
 */
function handleEdit(e) {
    e.preventDefault();
    const recordNumber = parseInt(document.getElementById('editRecordNumber').value, 10);
    const index = recordNumber - 1;

    if (index >= 0 && index < records.length) {
        records[index].name = document.getElementById('editName').value;
        records[index].age = document.getElementById('editAge').value;
        records[index].gender = document.getElementById('editGender').value;
        saveRecords();
        closeModal('editModal');
        editForm.reset();
    } else {
        showNotification('Invalid record number.', 'error');
    }
}

/**
 * Handles viewing a specific record.
 * @param {Event} e The form submission event.
 */
function handleView(e) {
    e.preventDefault();
    const recordNumber = parseInt(document.getElementById('viewRecordNumber').value, 10);
    const index = recordNumber - 1;

    if (index >= 0 && index < records.length) {
        const record = records[index];
        const content = `
            <div class="record-item">
                <h4>Record #${recordNumber}</h4>
                <div class="record-details">
                    <div class="record-detail"><span>Name:</span><span>${record.name}</span></div>
                    <div class="record-detail"><span>Age:</span><span>${record.age}</span></div>
                    <div class="record-detail"><span>Gender:</span><span>${record.gender}</span></div>
                </div>
            </div>
        `;
        document.getElementById('recordDisplayContent').innerHTML = content;
        document.getElementById('recordDisplayTitle').textContent = `Details for Record #${recordNumber}`;
        closeModal('viewModal');
        openModal('recordDisplayModal');
    } else {
        showNotification('Invalid record number.', 'error');
    }
}

/**
 * Removes a record from the list.
 * @param {string} position 'first' or 'last'.
 */
function removeRecord(position) {
    if (records.length === 0) {
        showNotification('No records to remove.', 'warning');
        return;
    }

    if (position === 'first') {
        records.shift();
    } else {
        records.pop();
    }

    saveRecords();
}

/**
 * Saves the records to the text file.
 */
function saveRecords() {
    const data = records.map(r => `${r.name},${r.age},${r.gender}`).join('\n');

    // In a real application, this would be an API call to a server to save the file.
    // For this simulation, we'll just update the display and show a notification.
    displayRecords();
    showNotification('Records updated successfully!', 'success');
    console.log("Simulating save with data:\n", data);
}

/**
 * Refreshes records from the source.
 */
function refreshRecords() {
    loadRecords();
}

/**
 * Shows a notification message.
 * @param {string} message The message to display.
 * @param {string} type 'success', 'error', 'warning', 'info'.
 */
function showNotification(message, type) {
    notification.textContent = message;
    notification.className = `notification show ${type}`;
    setTimeout(() => {
        notification.className = 'notification';
    }, 3000);
}

// Modal handling functions
function openModal(modalId) {
    document.getElementById(modalId).style.display = 'block';
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}

function showAddForm(position) {
    addPosition = position;
    document.getElementById('addModalTitle').textContent = `Add Record to ${position.charAt(0).toUpperCase() + position.slice(1)}`;
    openModal('addModal');
}

function showEditForm() {
    if (records.length === 0) {
        showNotification('No records available to edit.', 'warning');
        return;
    }

    const recordNumberInput = document.getElementById('editRecordNumber');
    recordNumberInput.max = records.length;

    // Pre-fill form if a record is selected
    recordNumberInput.addEventListener('change', () => {
        const index = parseInt(recordNumberInput.value, 10) - 1;
        if (index >= 0 && index < records.length) {
            const record = records[index];
            document.getElementById('editName').value = record.name;
            document.getElementById('editAge').value = record.age;
            document.getElementById('editGender').value = record.gender;
        } else {
            document.getElementById('editName').value = '';
            document.getElementById('editAge').value = '';
            document.getElementById('editGender').value = '';
        }
    });

    openModal('editModal');
}

function showViewForm() {
    if (records.length === 0) {
        showNotification('No records available to view.', 'warning');
        return;
    }
    document.getElementById('viewRecordNumber').max = records.length;
    openModal('viewModal');
}

// Close modals if clicked outside
window.onclick = function (event) {
    if (event.target.classList.contains('modal')) {
        closeModal(event.target.id);
    }
} 
