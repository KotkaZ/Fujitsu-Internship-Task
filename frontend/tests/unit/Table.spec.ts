import { mount } from "@vue/test-utils";
import Table from "@/components/Table.vue";

describe("Table.vue", () => {
  const feedbacks = [
    {
      id: 1,
      name: "Specific name",
      email: "specific@email.com",
      text: "Specific text",
      applications: ["Specific application"]
    },
    {
      id: 2,
      name: "Test Test",
      email: "test@test.com",
      text: "test",
      applications: ["Doctors portal"]
    }
  ];

  const wrapper = mount(Table, {
    props: { feedbacks }
  });

  it("renders the correct amount of feedbacks", () => {
    const rows = wrapper.findAll("tr");
    //-1 for header row
    expect(rows.length - 1).toEqual(feedbacks.length);
  });

  it("renders correct feedback information when passed", () => {
    expect(wrapper.html()).toContain(feedbacks[0].id);
    expect(wrapper.html()).toContain(feedbacks[0].name);
    expect(wrapper.html()).toContain(feedbacks[0].email);
    expect(wrapper.html()).toContain(feedbacks[0].text);
    expect(wrapper.html()).toContain(feedbacks[0].applications[0]);
  });
});
