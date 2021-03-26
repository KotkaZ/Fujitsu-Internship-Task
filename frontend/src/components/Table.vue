<template>
  <Card class="p-shadow-14">
    <template #content>
      <DataTable :value="feedbacks">
        <Column field="id" header="#" />
        <Column field="name" header="Name" />
        <Column field="email" header="Email" />
        <Column field="applications" header="Category">
          <template #body="{data}">
            <ul>
              <li v-for="cat in data.applications" :key="cat">{{ cat }}</li>
            </ul>
          </template>
        </Column>
        <Column field="text" header="Text" />
      </DataTable>
    </template>
  </Card>
</template>

<script>
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
export default {
  name: "Table",
  components: {
    Column,
    Card,
    DataTable
  },
  props: ["feedbacks"]
};
</script>

<style scoped></style>
