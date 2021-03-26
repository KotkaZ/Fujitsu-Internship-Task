<template>
  <Table :feedbacks="getFeedbacks" />
  <InputGroup class="p-mt-3" />
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
    ...mapGetters(["getFeedbacks"])
  },
  methods: {
    ...mapActions(["fetchFeedbacks"])
  },
  async created() {
    await this.fetchFeedbacks();
  }
};
</script>

<style scoped></style>
