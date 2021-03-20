<template>
  <Card>
    <template #title>
      Please give us feedback
    </template>
    <template #content>
      <div class="p-fluid">
        <div class="p-field">
          <div class="p-inputgroup">
            <span class="p-inputgroup-addon"> <i class="pi pi-user"></i> </span>
            <span class="p-float-label">
              <InputText id="name" type="text" v-model="name" />
              <label for="name">Name</label>
            </span>
          </div>
          <small v-show="validationErrors.name" class="p-error">{{
            validationErrors.name
          }}</small>
        </div>

        <div class="p-field">
          <div class="p-inputgroup">
            <span class="p-inputgroup-addon"
              ><i class="pi pi-envelope"></i
            ></span>
            <span class="p-float-label">
              <InputText id="email" type="email" v-model="email" />
              <label for="email">Email address</label>
            </span>
          </div>
          <small v-show="validationErrors.email" class="p-error">{{
            validationErrors.email
          }}</small>
        </div>

        <div class="p-field">
          <Textarea v-model="text" rows="5" cols="30" placeholder="Text" />
        </div>

        <div class="p-field">
          <Listbox
            v-model="selectedApplications"
            :options="groupedApplications"
            optionLabel="label"
            optionGroupLabel="label"
            optionGroupChildren="items"
            :multiple="true"
          >
            <template #optiongroup="slotProps">
              <div class="p-d-flex p-ai-center p-jc-center">
                <i
                  v-if="slotProps.option.code === 'Health'"
                  class="pi pi-sun"
                ></i>
                <i
                  v-else-if="slotProps.option.code === 'Remote'"
                  class="pi pi-globe"
                ></i>
                <i v-else class="pi pi-briefcase"></i>
                <div>{{ slotProps.option.label }}</div>
              </div>
            </template>
          </Listbox>
        </div>
      </div>
    </template>
    <template #footer>
      <div class="p-fluid">
        <Button icon="pi pi-send" label="Send" />
      </div>
    </template>
  </Card>
</template>

<script>
import Card from "primevue/card";
import Button from "primevue/button";
import InputText from "primevue/inputtext";
import Textarea from "primevue/textarea";
import Listbox from "primevue/listbox";
export default {
  name: "InputGroup",
  components: {
    Button,
    Card,
    InputText,
    Textarea,
    Listbox
  },
  data() {
    return {
      name: "",
      email: "",
      text: "",
      selectedApplications: [],
      validationErrors: {},
      groupedApplications: [
        {
          label: "Health",
          code: "Health",
          items: [
            { label: "Patients portal", value: "Patients portal" },
            { label: "Doctors portal", value: "Doctors portal" }
          ]
        },
        {
          label: "Remote visits portal",
          code: "Remote",
          items: [
            { label: "Registration", value: "Registration" },
            { label: "Virtual visit", value: "Virtual visit" }
          ]
        },
        {
          label: "Document management",
          code: "Docs",
          items: [
            { label: "OpenKM", value: "OpenKM" },
            { label: "Microsoft SharePoint", value: "Los Microsoft SharePoint" }
          ]
        }
      ]
    };
  }
};
</script>
