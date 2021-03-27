import { mount } from "@vue/test-utils";
import InputGroup from "@/components/InputGroup.vue";

describe("InputGroup.vue", () => {
  const inputData = {
    name: "Specific name",
    email: "specific@email.com",
    text: "Specific text",
    applications: []
  };

  const wrapper = mount(InputGroup);

  it("v-models are correctly linked", async () => {
    await wrapper.find('input[type="text"]').setValue(inputData.name);
    await wrapper.find('input[type="email"]').setValue(inputData.email);
    await wrapper.find("textarea").setValue(inputData.text);

    expect(wrapper.vm.feedback).toStrictEqual(inputData);
  });
});
