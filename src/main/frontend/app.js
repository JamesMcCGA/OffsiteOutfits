function fetchDataAndUpdateUI() {
    fetch('http://localhost:8081/TShirts')
        .then(response => response.json())
        .then(data => {
            renderTShirts(data);
        })
        .catch(error => console.error('Error fetching data:', error));
}


function renderTShirts(tShirts) {
    const tShirtsContainer = document.getElementById('tshirts-container');
    tShirtsContainer.innerHTML = ''; // Clear existing content

    tShirts.forEach(tShirt => {
        const tShirtElement = document.createElement('div');
        tShirtElement.classList.add('tshirt'); // Optional: Add a class for styling

        tShirtElement.innerHTML = `
      <p>T-Shirt ID: ${tShirt.tShirtId}</p>
      <p>Size: ${tShirt.size}</p>
      <p>Kit: ${tShirt.kit}</p>
      <!-- Add more details as needed -->
    `;

        tShirtsContainer.appendChild(tShirtElement);
    });
}


document.addEventListener('DOMContentLoaded', fetchDataAndUpdateUI);
