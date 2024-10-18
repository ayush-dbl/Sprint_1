// This function can be used to update categories based on the service type selected
function updateCategory() {
    const serviceType = document.getElementById('serviceType').value;
    const category = document.getElementById('category');

    category.innerHTML = ''; // Clear previous categories

    if (serviceType === 'Street Light') {
        const option1 = document.createElement('option');
        option1.value = 'Not Switched Off';
        option1.text = 'STREETLIGHT-NOT SWITCHED OFF';
        category.add(option1);

        const option2 = document.createElement('option');
        option2.value = 'Faulty';
        option2.text = 'STREETLIGHT FAULTY';
        category.add(option2);
    } else if (serviceType === 'Billing') {
        const option1 = document.createElement('option');
        option1.value = 'Incorrect Bill';
        option1.text = 'INCORRECT BILL';
        category.add(option1);

        const option2 = document.createElement('option');
        option2.value = 'Overcharged';
        option2.text = 'OVERCHARGED';
        category.add(option2);
    }
}

// Function to reset the form
function resetForm() {
    document.getElementById('complaintForm').reset();
}
