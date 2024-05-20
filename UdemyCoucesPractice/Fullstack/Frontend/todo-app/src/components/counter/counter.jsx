import { useState } from "react";
import "./counter.css";

import propTypes from "prop-types";

export default function Counter() {
  return (
    <div>
      <CounterButton by={1} />
      <CounterButton by={2} />
      <CounterButton by={3} />
    </div>
  );
}
function CounterButton({ by }) {
  // const buttonStyle = {
  //   fontSize: "30px",
  //   backgroundcolor: "#00a5ab",
  //   width: "100px",
  //   margin: "10px",
  //   color: "White",
  //   padding: "15px",
  //   borderRadius: "20px",
  // };

  const [count, setCount] = useState(0);
  //INFO: useState return two first is value and second is function to update state

  //console.log(by);

  function incrementCounterFunction() {
    setCount(count + by);
    console.log(count);
    //console.log("Increment clicked");
  }

  function decrementCounterFunction() {
    setCount(count - by);
    console.log(count);
    //console.log("Increment clicked");
  }
  return (
    <div className="Counter">
      <span className="count">{count}</span>
      <div>
        <button
          className="counterButton"
          onClick={incrementCounterFunction}
          // style={{ fontSize: "30px" }}
          // style={buttonStyle}
        >
          +{by}
        </button>
        <button className="counterButton" onClick={decrementCounterFunction}>
          -{by}
        </button>
      </div>
    </div>
  );
}

CounterButton.propTypes = {
  by: propTypes.number,
};

// CounterButton.defaultProps = {
//   by: 1,
// };
