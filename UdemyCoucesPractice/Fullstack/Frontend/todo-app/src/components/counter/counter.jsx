import { useState } from "react";
import "./Counter.css";

import propTypes from "prop-types";

export default function Counter() {
  const [count, setCount] = useState(0);
  function incrementCounterParentCounter(by) {
    setCount(count + by);
  }

  function decrementCounterParentFunction(by) {
    setCount(count - by);
  }

  return (
    <div>
      <span className="gcount">{count}</span>
      <CounterButton
        by={1}
        incrementMethod={incrementCounterParentCounter}
        decrementMethod={decrementCounterParentFunction}
      />
      <CounterButton
        by={2}
        incrementMethod={incrementCounterParentCounter}
        decrementMethod={decrementCounterParentFunction}
      />
      <CounterButton
        by={3}
        incrementMethod={incrementCounterParentCounter}
        decrementMethod={decrementCounterParentFunction}
      />
    </div>
  );
}
function CounterButton({ by, incrementMethod, decrementMethod }) {
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
    incrementMethod(by);
  }

  function decrementCounterFunction() {
    setCount(count - by);
    decrementMethod(by);
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
