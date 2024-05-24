import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import {
  createTodoApi,
  retrieveTodoApi,
  updateTodoApi,
} from "./api/TodoApiService.js";
import { useAuth } from "./Security/AuthContext";
import { Formik, Field, Form, ErrorMessage } from "formik";
import moment from "moment";

export default function TodoComponent() {
  const { id } = useParams();
  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");
  const authContext = useAuth();
  const navigate = useNavigate();

  const username = authContext.username;

  useEffect(() => retrieveTodo(), [id]);

  function retrieveTodo() {
    if (id != -1) {
      retrieveTodoApi(username, id)
        .then((response) => {
          console.log(response);
          setDescription(response.data.description);
          setTargetDate(response.data.targetDate);
        })
        .then((error) => console.log(error))
        .finally(() => console.log(""));
    }
  }

  function onSubmit(values) {
    console.log(values);
    const todo = {
      id: id,
      username: username,
      description: values.description,
      targetDate: values.targetDate,
      done: false,
    };
    console.log(todo);
    if (id == -1) {
      createTodoApi(username, todo)
        .then((response) => {
          navigate("/todos");
        })
        .then((error) => {
          console.log(error);
        })
        .finally(() => console.log("cleanup"));
    } else {
      updateTodoApi(username, id, todo)
        .then((response) => {
          navigate("/todos");
        })
        .then((error) => {
          console.log(error);
        })
        .finally(() => console.log("cleanup"));
    }
  }

  function validate(values) {
    let error = {
      // description: "Enter a valid description",
      // targetDate: "Enter a valid date",
    };

    if (values.description.length < 5) {
      error.description = "Enter at least 5 character";
    }
    if (
      values.targetDate == null ||
      validate.targetDate == "" ||
      !moment(values.targetDate).isValid()
    ) {
      error.targetDate = "Enter a valid date";
    }
    return error;
  }
  return (
    <div className="container">
      <h1>Enter Todo details</h1>
      <div>
        <Formik
          initialValues={{ description, targetDate }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />
              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  name="description"
                  className="form-control"
                />
              </fieldset>
              <fieldset className="form-group">
                <label>Target Date</label>
                <Field type="date" name="targetDate" className="form-control" />
              </fieldset>
              <div>
                <button className="btn btn-success m-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}
