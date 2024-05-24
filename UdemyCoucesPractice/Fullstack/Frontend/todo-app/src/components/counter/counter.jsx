import { useState } from "react";
import "./Counter.css";

import CounterButton from "./CounterButton";

export default function Counter() {
  const [count, setCount] = useState(0);
  function incrementCounterParentCounter(by) {
    setCount(count + by);
  }

  function decrementCounterParentFunction(by) {
    setCount(count - by);
  }

  function resetCounter() {
    setCount(0);
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
      <button className="resetBtn" onClick={resetCounter}>
        Reset
      </button>
    </div>
  );
}
