import React from 'react'
import { Link, useHistory } from 'react-router-dom'
import axios from 'axios';
import { useEffect, useState } from 'react'
import "./header.css"

const Header = () => {
  const [productList,setproductList]=useState([])
  const history = useHistory();

  useEffect(()=>{
      axios.get(`http://localhost:8080/products/getProduct`,{

      }).then((response)=>{
          console.log(response.data)
          setproductList(response.data)
         
      }).catch((error)=>{
          console.log(error.response)
      });
  },[]);

  const handleKeyDown = (event) => {
    if (event.keyCode === 13) { // Check if the user pressed Enter
      const searchValue = event.target.value;
    window.location.href = `/product/${searchValue}`;
    }
  };
 
  const logout = () => {
    // localStorage.removeItem('user');
    // localStorage.removeItem('name');
    localStorage.clear();
    window.location.href='/login';
  }



  return (
    <div className='max-width absolute-center header'>
     <a href='/home'><img src='https://scontent.fpnq7-2.fna.fbcdn.net/v/t39.30808-6/300374525_439235041557981_998846646059063545_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=6iGKU--J878AX-QNcCO&_nc_ht=scontent.fpnq7-2.fna&oh=00_AfAT_3tn5FvC-8482heR1Kws9nQJFSs6a3Tl8bJWFBMzcg&oe=64021289'
        alt='pizza-hut-logo'
        className='header-logo '></img> </a> 
      <div className='title'>Pizza Hub</div>

      <div className="header-right">
        <div className="header-location-search-container">
          {/* <div className="location-wrapper">
            <div className="location-icon-name">
              <i className="fi fi-rr-marker absolute-center location-icon"></i>
              <div>Bangalore</div>
            </div>
            <i className="fi fi-rr-caret-down absolute-center"></i>
          </div>     */}
          {/* need to delete from here to top */}
          {/* <div className="location-search-separator"></div> */}
          <div className="header-searchBar">
            <i className="fi fi-rr-search absolute-center search-icon"></i>
            <input type={'text'}
              className="search-input"
              onKeyDown={handleKeyDown}
              placeholder="Search for restaurant, cuisine or a dish" list='products'
            />
            <datalist id='products'>
              {productList.map((item)=>{return (  <option value={item.productName}  ></option>)})}
              
              {/* // <option value='Burger'></option>
              // <option value='Pasta'></option>
              // <option value='Sandwich'></option>
              // <option value='Biryani'></option>
              // <option value='Momos'></option>
              // <option value='Dosa'></option>
              // <option value='Idli'></option>
              // <option value='Pav Bhaji'></option>
              // <option value='Chole Bhature'></option> */}
            </datalist>
          </div>
        </div>

        <div className="profile-wrapper">
          <img
            src="https://b.zmtcdn.com/images/user_avatars/mug_2x.png?fit=around%7C100%3A100&crop=100%3A100%3B%2A%2C%2A"
            className="header-profile-image"
            alt="Profile"
          />
          <a className="header-username" href='/profile'>{(localStorage.getItem("name"))}</a>&nbsp;&nbsp;&nbsp;

          {/* <i className="fi fi-rr-angle-small-down absolute-center profile-options-icon">
          </i> */}
         <span className="header-username">Wishlist</span>&nbsp;&nbsp;&nbsp;
         
         <a className="header-username" href='/cart'>cart</a>&nbsp;&nbsp;&nbsp;
         
          <div className="header-username" onClick={logout} >Logout</div>&nbsp;&nbsp;&nbsp;
          
      </div>
        </div>
        




    </div>

  )
}

export default Header
