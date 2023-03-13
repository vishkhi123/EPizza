import axios from 'axios';
import React, { useEffect, useState } from 'react'
import "./menuCollections.css";

const MenuCollections = (props) => {

    const [productList,setproductList]=useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8080/products/getProducts/${props.activeTab}`,{

        }).then((response)=>{
            console.log(response.data)
            setproductList(response.data)
           
        }).catch((error)=>{
            console.log(error.response)
        });
    },[]);

  return (

    <div className='container'>
        <div className='row'>
        {productList.map((item)=>{

            return(

                <div class="col-md-4">
                {/* <h4 class="text-center"><strong>STYLE 1</strong></h4> */}
                <hr/>
                <div class="profile-card-2"><img src="https://c4.wallpaperflare.com/wallpaper/234/543/684/food-pizza-wallpaper-preview.jpg"  class="img img-responsive"/>
                    <div class="profile-name">{item.productName}</div>
                    <div class="profile-username">{item.description}</div>
                    <div class="profile-icons"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-linkedin"></i></a></div>
                </div>
            </div>
           
        )})
        
    }
      </div>  
    </div>
   

)
}

export default MenuCollections
