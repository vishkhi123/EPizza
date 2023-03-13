import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useHistory, useParams } from 'react-router-dom';
import "./product.css"

const Product = (props) => {
  const history=useHistory();
    const [product,setproduct]=useState({});
    const {prodname}=useParams();
     const api="http://localhost:8080/products/getProduct/"+prodname;
    //  const [quantity,setquantity]=useState({qty:1})
     const [cartItem,setcartItem]=useState({quantity:NaN,totalPrice: 0})
   

    const handleInputChange = (e) => {
        
        const { id, value } = e.target
        const quantity=value;
        const totalPrice = product.price * value;
        setcartItem({ ...cartItem, quantity,totalPrice });
       
        

        
      
    }
   

    useEffect(()=>{
        axios.get(api,{

        }).then((response)=>{
            console.log(response.data)
            setproduct(response.data)
        }).catch((error)=>{
            console.log(error.response)
        });
    },[]);

    const AddToCart=(event)=>
    {
       

      
      const api=`http://localhost:8080/users/addtocart/${product.productName}/${localStorage.getItem("email")}`;
      axios.post(api,cartItem)
      .then(response => {
        alert(response.data);
        history.push("/cart")
        window.location.reload("/cart");

        
        
    })
    .catch(error => {
        console.log(error);
    });

    }
       



  return (
    <body>
  <div class="lightbox-blanket">
    <div class="pop-up-container">
      <div class="pop-up-container-vertical">
        <div class="pop-up-wrapper">
          <div class="go-back" onclick="GoBack();"><i class="fa fa-arrow-left"></i>
          </div>
          <div class="product-details">
            <div class="product-left">
              <div class="product-info">
                <div class="product-manufacturer">{product.productName}
                </div>
                <div class="product-title">
                
                </div>
                <div class="product-price" price-data="320.03">
                Price:  {product.price} Rs
                </div>
              </div>
              <div class="product-image">
                <img src="https://c4.wallpaperflare.com/wallpaper/234/543/684/food-pizza-wallpaper-preview.jpg" />
              </div>
            </div>
            <div class="product-right">
              <div class="product-description">
                {product.description}
              </div>
              <div class="product-available">
                In stock.
                 {/* <span class="product-extended"><a href="#">Buy Extended Warranty</a></span> */}
              </div>
             
              <div class="product-quantity">
                <label for="product-quantity-input" class="product-quantity-label" >Quantity</label>
                <div class="product-quantity-subtract">
                  <i class="fa fa-chevron-left"></i>
                </div>
                <div>
                  <input type="number" id="quantity" placeholder="1"  onChange={(e)=>handleInputChange(e)} />
                </div>
                <div class="product-quantity-add">
                  <i class="fa fa-chevron-right"></i>
                </div>

                <div class="product-checkout-actions " >
              <a class="add-to-cart btn btn-danger" href="#" onclick="AddToCart(event);">Add to Wishlist</a>
              
                <a class="add-to-cart btn  btn-primary"  onClick={AddToCart} >Add to Cart</a>
              
                
              </div>




              </div>
            </div>
            <div class="product-bottom">
              <div class="product-checkout">
                Total Price
                <div class="product-checkout-total">
                  <i class="fa fa-usd"></i>
                  <div class="product-checkout-total-amount">
                    {cartItem.totalPrice}
                  </div>
                </div>
                
              </div>
             
             
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
  )
}

export default Product
