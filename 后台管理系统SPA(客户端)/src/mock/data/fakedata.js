import Mock from 'mockjs';

const Arrangements = [];

for (let i = 0; i < 56; i++) {
    Arrangements.push(Mock.mock({
    id: Mock.Random.guid(),
    user: Mock.Random.cname(),
    goods_id: Mock.Random.guid(),
    location: Mock.mock('@county(true)'),
    time: Mock.Random.datetime(),
  }));
}

const Goods = [];

for (let i = 0; i < 56; i++) {
    Goods.push(Mock.mock({
    id: Mock.Random.guid(),
    user: Mock.Random.cname(),
    content: Mock.Random.csentence(15,30),
  }));
}

export { Arrangements, Goods };

