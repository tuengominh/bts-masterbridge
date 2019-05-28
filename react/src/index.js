import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import Main from './Main';
import * as serviceWorker from './serviceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(<Main />, document.getElementById('root'));

serviceWorker.unregister();
