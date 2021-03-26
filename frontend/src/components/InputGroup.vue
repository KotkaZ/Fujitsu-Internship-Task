<template>
  <Card class="p-shadow-14">
    <template #title>
      Please give us feedback
    </template>
    <template #content>
      <div class="p-fluid">
        <div class="p-field">
          <div class="p-inputgroup">
            <span class="p-inputgroup-addon"> <i class="pi pi-user"></i> </span>
            <span class="p-float-label">
              <InputText id="name" type="text" v-model="feedback.name" />
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
              <InputText id="email" type="email" v-model="feedback.email" />
              <label for="email">Email address</label>
            </span>
          </div>
          <small v-show="validationErrors.email" class="p-error">{{
            validationErrors.email
          }}</small>
        </div>

        <div class="p-field">
          <Textarea v-model="feedback.text" rows="5" placeholder="Text" />
          <small v-show="validationErrors.text" class="p-error">{{
            validationErrors.text
          }}</small>
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
          <small v-show="validationErrors.applications" class="p-error">{{
            validationErrors.applications
          }}</small>
        </div>
      </div>
    </template>
    <template #footer>
      <div class="p-fluid">
        <Button icon="pi pi-send" label="Send" @click="submitData()" />
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

import joi from "joi";
import { mapActions } from "vuex";

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
      feedback: {
        name: "",
        email: "",
        text: "",
        applications: []
      },
      validationErrors: {},
      selectedApplications: [],
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
  },
  methods: {
    ...mapActions(["sumbitFeedback"]),
    validateData: function(feedback) {
      const schema = joi.object().keys({
        name: joi
          .string()
          .min(3)
          .max(45)
          .required()
          .pattern(/^([A-ZÕÄÖÜ][a-zõäöü]+)([ -][A-ZÕÄÖÜ][a-zõäöü]+)*$/),
        email: joi
          .string()
          .email({ tlds: { allow: false } })
          .required(),
        text: joi
          .string()
          .max(255)
          .required(),
        applications: joi
          .array()
          .min(1)
          .required()
      });
      return schema.validate(feedback, { abortEarly: false });
    },
    submitData: async function() {
      try {
        this.feedback.applications = [];

        this.selectedApplications.forEach(v =>
          this.feedback.applications.push(v.value)
        );
        this.validationErrors = {};
        const validationResult = this.validateData(this.feedback);
        if (validationResult.error) {
          validationResult.error.details.forEach(
            err => (this.validationErrors[err.context.key] = err.message)
          );
          throw new Error("Validation error!");
        }

        await this.sumbitFeedback(this.feedback);

        for (const key in this.feedback) delete this.feedback[key];

        this.selectedApplications = [];
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>
