import React from 'react'
import Thankyou from '../../images/Thankyou.jpg'
import './order.css'

const Order = () => {
  const home=()=>{
    window.location.href="/home";
  }
  return (
    
    <img  className='img' src={Thankyou} height={'90%'} onClick={home}></img>




    
  )
}

export default Order