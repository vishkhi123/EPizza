import React, { useState } from 'react'
import "./menu.css"
import Filters from '../common/filters/Filters'; 
import MenuCollections from './MenuCollections/MenuCollections';
import Burger from '../categories/Burger/Burger';
import Sandwich from '../categories/Sandwich/Sandwich';
import Pizza from '../categories/Pizza/Pizza';
import FrenchFries from '../categories/FrenchFries/FrenchFries';
import Bevarages from '../categories/Beverages/Bevarages';
import CategoryTab from '../categories/CategoryTab/CategoryTab';


const MenuFilters = [
  {
    id: 1,
    icon: <i className="fi fi-rr-settings-sliders absolute-center"></i>,
    title: "Filters",
  },
  {
    id: 2,
    icon: <i className="fi fa-leaf absolute-center"></i>,
    title: "Pure Veg",
  },
  // <i class="fa-solid fa-leaf"></i>
  {
    id: 3,
    title: "Non Veg",
  },
  // {
  //   id: 4,
  //   title: "Pure Veg",
  // },
  // {
  //   id: 5,
  //   title: "Delivery Time",
  //   icon: <i className="fi fi-rr-apps-sort absolute-center"></i>,
  // },
  // {
  //   id: 6,
  //   title: "Great Offers",
  // },
];

const Menu = () => {

  const [activeTab,setActiveTab]=useState("");

  // const getCorrectScreen = (tab) => {

  //   switch(tab)
  //   {
  //       case "Pizza":
  //         setActiveTab("Pizza");
  //           return ;
  //       case "Burger":
  //         setActiveTab("Burger");
  //           return ;
  //       case "Sandwich":
  //           return <Sandwich></Sandwich>
  //       case "FrenchFries":
  //           return <FrenchFries></FrenchFries>
  //       case "Bevarages":
  //           return <Bevarages></Bevarages>
        
  //       default:
  //           return <Pizza></Pizza>
  //   }
  // }

  return (
    <div>
      <div className="max-width">
        {/* <Filters filterList={MenuFilters} /> */}
        <CategoryTab activeTab={activeTab} setActiveTab={setActiveTab} ></CategoryTab>
        {getCorrectScreen(activeTab)}
        {/* <MenuCollections activeTab={activeTab}></MenuCollections> */}
        
        

      </div>
    </div>
  )
}

const getCorrectScreen = (tab) => {

  switch(tab)
  {
      case "Pizza":
        
          return <Pizza></Pizza>;
      case "Burger":
        
          return <Burger></Burger>; 
      case "Sandwich":
          return <Sandwich></Sandwich>
      case "FrenchFries":
          return <FrenchFries></FrenchFries>
      case "Bevarages":
          return <Bevarages></Bevarages>
      
      default:
          return <Pizza></Pizza>
  }
}
export default Menu
