'use strict';

var _player = require('build/js4_BabelSystem/player.js');

var _game = require('build/js4_BabelSystem/game.js');

var game = _interopRequireWildcard(_game);

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

// NB path Babel dir

// add click handler to the start game button
// Transpiling with Babel for CommonJS and SystemJS

// NB path in imports => path to Babel working directory

document.getElementById('startGame').addEventListener('click', function () {
    (0, _player.setName)(document.getElementById('playername').value); // player.
    game.printGame(); // game.
});

// add click handler to the calculate score button
// NB path Babel dir
document.getElementById('calculate').addEventListener('click', function () {
    game.calculateScore(); // game.
});

// set the default number of problems
document.getElementById('problemCount').value = game.getProblemCount(); // game.
//# sourceMappingURL=app.js.map