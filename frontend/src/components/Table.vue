<template>
  <DataTable :value="feedbacks">
    <Column field="id" header="#"></Column>
    <Column field="name" header="Name"></Column>
    <Column field="email" header="Email"></Column>
    <Column field="category" header="Category"></Column>
    <Column field="text" header="Text"></Column>
  </DataTable>
</template>

<script>
import DataTable from "primevue/datatable";
import Column from "primevue/column";
export default {
  name: "Table",
  components: {
    Column,
    DataTable
  },
  props: ["feedbacks"]
};
</script>

<style scoped></style>
