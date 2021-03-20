<template>
  <Table />
  <InputGroup :feedbacks="getFeedbacks" />
</template>

<script>
import InputGroup from "@/components/InputGroup.vue";
import Table from "@/components/Table.vue";

import { mapGetters, mapActions } from "vuex";

export default {
  components: {
    InputGroup,
    Table
  },
  computed: {
    ...mapGetters("getFeedbacks")
  },
  methods: {
    ...mapActions("fetchFeedbacks")
  },
  mounted() {
    this.fetchFeedbacks();
  }
};
</script>

<style scoped></style>
