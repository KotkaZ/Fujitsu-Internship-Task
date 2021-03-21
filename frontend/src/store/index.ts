import { createStore } from "vuex";
import axios from "../plugins/axios";

export default createStore({
  state: {
    feedbacks: []
  },
  getters: {
    getFeedbacks: state => state.feedbacks
  },
  mutations: {
    setFeedbacks: (state, feedbacks) => (state.feedbacks = feedbacks)
  },
  actions: {
    async fetchFeedbacks({ commit }) {
      const response = await axios.get("feedback");
      commit("setFeedbacks", response.data);
    },
    async sumbitFeedback({ dispatch }, feedback) {
      await axios.post("feedback", feedback);
      dispatch("fetchFeedbacks");
    }
  },
  modules: {}
});
