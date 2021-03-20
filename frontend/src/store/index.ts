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
      const feedbacks = await axios.get("feedbacks");
      commit("setFeedbacks", feedbacks);
    },
    async sumbitFeedback({ dispatch }, feedback) {
      await axios.post("feedbacks", feedback);
      dispatch("fetchFeedbacks");
    }
  },
  modules: {}
});
