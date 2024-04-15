const express = require('express');
const app = express();
const PORT = process.env.PORT || 4000;

// Define route handler for the root endpoint
app.get('/', (req, res) => {
  // Render the shop HTML
  const shopHtml = `<!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>T-Shirt Shop</title>
      <style>
          /* CSS for styling the shop */
          .tshirt {
              width: 200px;
              margin: 10px;
              padding: 10px;
              border: 1px solid #ccc;
              border-radius: 5px;
              display: inline-block;
              text-align: center;
          }
          .tshirt img {
              max-width: 100%;
              height: auto;
          }
      </style>
  </head>
  <body>
      <h1>Welcome to Our T-Shirt Shop!</h1>
      
      <!-- Shop Container -->
      <div id="shop">
          <!-- T-Shirt items will be dynamically added here -->
      </div>
  
      <!-- Cart Container -->
      <div id="cart">
          <h2>Cart</h2>
          <ul id="cart-items"></ul>
          <p id="total"></p>
      </div>
  
      <script>
          // Mock t-shirt data
          const tshirts = [
              { id: 1, name: "T-Shirt 1", price: 20, image: "tshirt1.jpg" },
              { id: 2, name: "T-Shirt 2", price: 25, image: "tshirt2.jpg" },
              { id: 3, name: "T-Shirt 3", price: 18, image: "tshirt3.jpg" },
              { id: 1, name: "T-Shirt 1", price: 20, image: "tshirt1.jpg" },
              { id: 2, name: "T-Shirt 2", price: 25, image: "tshirt2.jpg" },
              { id: 3, name: "T-Shirt 3", price: 18, image: "tshirt3.jpg" },
              { id: 1, name: "T-Shirt 1", price: 20, image: "tshirt1.jpg" },
              { id: 2, name: "T-Shirt 2", price: 25, image: "tshirt2.jpg" },
              { id: 3, name: "T-Shirt 3", price: 18, image: "tshirt3.jpg" },
              { id: 1, name: "T-Shirt 1", price: 20, image: "tshirt1.jpg" },
              { id: 2, name: "T-Shirt 2", price: 25, image: "tshirt2.jpg" },
              { id: 3, name: "T-Shirt 3", price: 18, image: "tshirt3.jpg" },
          ];
  
          // Cart array to store added items
          const cart = [];
  
          // Function to update cart UI
          function updateCartUI() {
              const cartItems = document.getElementById('cart-items');
              const totalContainer = document.getElementById('total');
              
              // Clear existing items and total
              cartItems.innerHTML = '';
              totalContainer.textContent = '';
  
              // Calculate total price
              let totalPrice = 0;
              cart.forEach(item => {
                  totalPrice += item.price;
                  const li = document.createElement('li');
                  li.textContent = item.name + ' - $' + item.price.toFixed(2);
                  cartItems.appendChild(li);
              });
  
              // Display total price
              totalContainer.textContent = 'Total: $' + totalPrice.toFixed(2);
          }
  
          // Event listener for add to cart buttons
          document.addEventListener('click', function(event) {
              if (event.target.classList.contains('add-to-cart')) {
                  const tshirt = event.target.parentNode;
                  const id = tshirt.getAttribute('data-id');
                  const name = tshirt.querySelector('h2').textContent;
                  const price = parseFloat(tshirt.querySelector('p').textContent.slice(1));
                  addToCart({ id, name, price });
              }
          });
  
          // Function to add item to cart
          function addToCart(item) {
              cart.push(item);
              updateCartUI();
          }
  
          // Render t-shirt items
const shopContainer = document.getElementById('shop');
tshirts.forEach(tshirt => {
    const div = document.createElement('div');
    div.className = 'tshirt';
    div.setAttribute('data-id', tshirt.id);
    div.innerHTML = '<img src="' + tshirt.image + '" alt="' + tshirt.name + '">' +
                    '<h2>' + tshirt.name + '</h2>' +
                    '<p>$' + tshirt.price.toFixed(2) + '</p>' +
                    '<button class="add-to-cart">Add to Cart</button>';
    shopContainer.appendChild(div);
});

      </script>
  </body>
  </html>
  `;

  // Send the rendered HTML to the client
  res.send(shopHtml);
});

// Endpoint to get all t-shirts
app.get('/tshirts', (req, res) => {
  res.json(tshirts);
});

// Endpoint to get a single t-shirt by ID
app.get('/tshirts/:id', (req, res) => {
  const id = parseInt(req.params.id);
  const tshirt = tshirts.find(tshirt => tshirt.id === id);
  if (!tshirt) {
    res.status(404).json({ message: "T-Shirt not found" });
  } else {
    res.json(tshirt);
  }
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
