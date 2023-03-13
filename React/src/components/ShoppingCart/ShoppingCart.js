import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react'
import "./shoppingcart.css"
import { Redirect, useHistory } from 'react-router-dom';

const ShoppingCart = () => {
    

    
      

     const [cartItemList,setcartItemList]=useState([])
    let finalPrice=0;

    
  useEffect(()=>{
    axios.get(`http://localhost:8080/users/getcart/${localStorage.getItem("email")}`,{

    }).then((response)=>{
        console.log(response.data)
        setcartItemList(response.data)
       
    }).catch((error)=>{
        console.log(error.response)
    });
},[]);

const removefromcart=(x)=>{
    // deletefromcart
   
    axios.post(`http://localhost:8080/users/deletefromcart/${x}`,{

}).then((response)=>{
    console.log(response.data)
    alert(response.data)

   
}).catch((error)=>{
    console.log(error.response)
});

window.location.reload();

};

const checkout=()=>{
    alert("checkout")
   window.location.href="/payment/"+finalPrice;
}



    return (

        <div class="card">
            <div class="row">
                <div class="col-md-8 cart">
                    <div class="title">
                        <div class="row">
                            <div class="col"><h4><b>Shopping Cart</b></h4></div>
                            <div class="col align-self-center text-right text-muted">3 items</div>
                        </div>
                    </div>
                    {cartItemList.map((item) => {
                        const url = "/product/" + item.productName;
                        finalPrice+=item.totalPrice;
                        return (
                            <div class="row border-top border-bottom">
                            <div class="row main align-items-center">
                                <div class="col-2"><img class="img-fluid" src="https://c4.wallpaperflare.com/wallpaper/234/543/684/food-pizza-wallpaper-preview.jpg"/></div>
                                <div class="col">
                                    <div class="row text-muted"></div>
                                    <div class="row cross">{item.productName}</div>
                                </div>
                                <div class="col">
                                    <a href="#">-</a><a href="#" class="border">{item.quantity}</a><a href="#">+</a>
                                </div>
                                <div class="col"> {item.totalPrice} Rs <span class="close"><a className='cross' href='#' target="_self" onClick={()=> {removefromcart(item.cartId)}}> &#10005;</a></span></div>
                            </div>
                        </div>

                            

                        )
                    })}

                    {/* <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/1GrakTl.jpg"/></div>
                            <div class="col">
                                <div class="row text-muted">Shirt</div>
                                <div class="row">Cotton T-shirt</div>
                            </div>
                            <div class="col">
                                <a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a>
                            </div>
                            <div class="col">&euro; 44.00 <span class="close">&#10005;</span></div>
                        </div>
                    </div> */}
                     {/* <div class="row">
                        <div class="row main align-items-center">
                            <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/ba3tvGm.jpg" /></div>
                            <div class="col">
                                <div class="row text-muted">Shirt</div>
                                <div class="row">Cotton T-shirt</div>
                            </div>
                            <div class="col">
                                <a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a>
                            </div>
                            <div class="col">&euro; 44.00 <span class="close">&#10005;</span></div>
                        </div>
                    </div>
                    <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/pHQ3xT3.jpg" /></div>
                            <div class="col">
                                <div class="row text-muted">Shirt</div>
                                <div class="row">Cotton T-shirt</div>
                            </div>
                            <div class="col">
                                <a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a>
                            </div>
                            <div class="col">&euro; 44.00 <span class="close">&#10005;</span></div>
                        </div>
                    </div> */}
                    <div class="back-to-shop"><a href="#">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
                </div> 
                <div class="col-md-4 summary">
                    <div><h5><b>Summary</b></h5></div>
                    <hr />
                    <div class="row">
                        <div class="col" style={{ paddingLeft: '0' }}>ITEMS 3</div>
                        <div class="col text-right">Rs {finalPrice}</div>
                    </div>
                    {/* <form>
                        <p>SHIPPING</p>
                        <select><option class="text-muted">Standard-Delivery- &euro;5.00</option></select>
                        <p>GIVE CODE</p>
                        <input id="code" placeholder="Enter your code" />
                    </form> */}
                    <div class="row" style={{ borderTop: '1px solid rgba(0,0,0,.1)' }}>
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right">Rs {finalPrice}</div>
                    </div>
                    <button class="btn" onClick={checkout}>CHECKOUT</button>
                </div>
            </div>



        </div>


    )
}

export default ShoppingCart
