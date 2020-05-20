const path = require('path');

module.exports = {
  rootDir: 'D:\\project\\软件工程\\2020_software_engineering_practice\\后台管理系统SPA(客户端)/', // 类似 webpack.context
  moduleFileExtensions: [ // 类似 webpack.resolve.extensions
    'js',
    'json',
    'vue',
  ],
  moduleNameMapper: {
    '^@/(.*)$': '<rootDir>/src/$1', // 类似 webpack.resolve.alias
  },
  transform: { // 类似 webpack.module.rules
    '^.+\\.js$': '<rootDir>/node_modules/babel-jest',
    '.*\\.(vue)$': '<rootDir>/node_modules/vue-jest',
  },
  testPathIgnorePatterns: ['./node_modules/'],
  setupFiles: ['D:\\project\\软件工程\\2020_software_engineering_practice\\后台管理系统SPA(客户端)\\test\\util\\setup'], // 类似 webpack.entry
  coverageDirectory: '<rootDir>/test/unit/coverage', // 类似 webpack.output
  collectCoverageFrom: [ // 类似 webpack 的 rule.include
    'src/**/*.{js,vue}',
    '!src/main.js',
    '!src/api/**',
    '!src/mock/**',
    '!src/vuex/**',
    '!build/**',
    '!node_modules/**',
    '!src/router.js',
    '!src/common/js/**'
  ],
};