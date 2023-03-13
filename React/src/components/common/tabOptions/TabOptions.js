import React from 'react'
import "./tabOptions.css";


const tabs = [
  {
    id: 1,
    name: "Home",
    active_img:
      "https://cdn-icons-png.flaticon.com/128/2544/2544087.png",
    backdrop: "#FCEEC0",
    inactive_img:
      "https://cdn-icons-png.flaticon.com/128/2413/2413074.png",
  },
  {
    id: 2,
    name: "Menu",
    active_img:
      "https://b.zmtcdn.com/data/o2_assets/30fa0a844f3ba82073e5f78c65c18b371616149662.png",
    backdrop: "#E5F3F3",
    inactive_img:
      "https://b.zmtcdn.com/data/o2_assets/78d25215ff4c1299578ed36eefd5f39d1616149985.png",
  },
  {
    id: 3,
    name: "Register",
    active_img:
      "https://cdn-icons-png.flaticon.com/128/9684/9684447.png",
    backdrop: "#EDf4FF",
    inactive_img:
      "https://cdn-icons-png.flaticon.com/128/9424/9424670.png",
  },
  {
    id: 4,
    name: "Login",
    active_img:
      "https://cdn-icons-png.flaticon.com/128/3870/3870822.png",
    backdrop: "#EDf4FF",
    inactive_img:
      "https://cdn-icons-png.flaticon.com/128/3293/3293331.png",
  },
  {
    id: 5,
    name: "About",
    active_img:
      "https://cdn-icons-png.flaticon.com/128/189/189664.png",
    backdrop: "#EDf4FF",
    inactive_img:
      "https://cdn-icons-png.flaticon.com/128/1/1176.png",
  },
  {
    id: 6,
    name: "Contact Us",
    active_img:
      "https://cdn-icons-png.flaticon.com/128/9855/9855386.png",
    backdrop: "#EDf4FF",
    inactive_img:
      "https://cdn-icons-png.flaticon.com/128/9855/9855525.png",
  }
];

const TabOptions = ({activeTab,setActiveTab}) => {
  return (
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
  )
}

export default TabOptions
