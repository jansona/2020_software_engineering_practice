import { shallowMount } from '@vue/test-utils';
import Arrangements from '../../src/pages/Arrangements';

describe('<hello-world/>', () => {
  it('should render correct contents', () => {
    const wrapper = shallowMount(Arrangements);
    // expect(wrapper.find('.hello h1').text())
    //   .toEqual('Welcome to Your Vue.js App');
    expect(wrapper.user.toEqual(''));
  });
});
