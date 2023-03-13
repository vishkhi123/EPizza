import React from 'react'
import MenuCollections from '../../Menu/MenuCollections/MenuCollections';
import "./categoryTab.css"


const tabs = [
    {
      id: 1,
      name: "Pizza",
      active_img:
        "https://cdn-icons-png.flaticon.com/128/8764/8764918.png",
      backdrop: "#FCEEC0",
      inactive_img:
        "https://cdn-icons-png.flaticon.com/128/8764/8764937.png",
    },
    {
      id: 2,
      name: "Burger",
      active_img:
        "https://cdn-icons-png.flaticon.com/128/9745/9745057.png",
      backdrop: "#E5F3F3",
      inactive_img:
        "https://cdn-icons-png.flaticon.com/128/9744/9744847.png",
    },
    {
      id: 3,
      name: "Sandwich",
      active_img:
        "https://cdn-icons-png.flaticon.com/128/1864/1864081.png",
      backdrop: "#EDf4FF",
      inactive_img:
        "https://cdn-icons-png.flaticon.com/128/7665/7665050.png",
    },
    {
      id: 4,
      name: "FrenchFries",
      active_img:
        "https://cdn-icons-png.flaticon.com/128/7478/7478250.png",
      backdrop: "#EDf4FF",
      inactive_img:
        "https://cdn-icons-png.flaticon.com/128/3635/3635569.png",
    },
    {
      id: 5,
      name: "Bevarages",
      active_img:
        "https://cdn-icons-png.flaticon.com/128/3081/3081985.png",
      backdrop: "#EDf4FF",
      inactive_img:
        "https://cdn-icons-png.flaticon.com/128/3081/3081866.png",
    },
    // {
    //   id: 6,
    //   name: "Contact Us",
    //   active_img:
    //     "https://cdn-icons-png.flaticon.com/128/9855/9855386.png",
    //   backdrop: "#EDf4FF",
    //   inactive_img:
    //     "https://cdn-icons-png.flaticon.com/128/9855/9855525.png",
    // }
  ];

const CategoryTab = ({activeTab,setActiveTab}) =>{
    return (
        <div className='category'>
      <div className="tab-options">
      <div className="options-wrapper max-width">
        {tabs.map((tab) => (
          <div
            className={`tab-item absolute-center cur-po ${
              activeTab === tab.name && "active-tab"
            }`}
            onClick={() => setActiveTab(tab.name)}
          >
            <div
              className="tab-image-container absolute-center"
              style={{
                backgroundColor: `${
                  activeTab === tab.name ? tab.backdrop : ""
                }`,
              }}
            >
              <img
                src={activeTab === tab.name ? tab.active_img : tab.inactive_img}
                className="tab-image"
                alt={tab.name}
              />
            </div>
            <div className="tab-name">{tab.name}</div>

           
            
          </div>
         
        ))}
      </div>
    </div>


    {/* <MenuCollections activeTab={activeTab}></MenuCollections> */}
    </div>
    )
  }

export default CategoryTab
