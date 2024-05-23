import apiClient from "./ApiClient";

export const retrieveTodosApi = (username) =>
  apiClient.get(`/user/${username}/todos`);

export const deleteTodoApi = (username, id) =>
  apiClient.delete(`/user/${username}/todos/${id}`);

export const retrieveTodoApi = (username, id) =>
  apiClient.get(`/user/${username}/todos/${id}`);

export const updateTodoApi = (username, id, todo) =>
  apiClient.put(`/user/${username}/todos/${id}`, todo);

export const createTodoApi = (username, todo) =>
  apiClient.post(`/user/${username}/todos`, todo);
