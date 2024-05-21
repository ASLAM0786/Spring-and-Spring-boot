import { useState } from "react";
import propTypes from "prop-types";

export default function CounterButton({
  by,
  incrementMethod,
  decrementMethod,
}) {
  const [count, setCount] = useState(0);
  //INFO: useState return two first is value and second is function to update state

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
      <div>
        <button className="counterButton" onClick={incrementCounterFunction}>
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
