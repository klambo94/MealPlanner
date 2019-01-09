import React, { Component } from 'react';
import {BrowserRouter, Switch, Route, Link} from 'react-router-dom';
import Recipes from './componets/Recipes';

class App extends Component {
  render() {
    return (
      <div className="App">
          <BrowserRouter>
              <div>
                  <Link to="/recipes">Recipes</Link>{' '}
                  <Switch>
                      <Route path="/recipes" component={Recipes}/>
                  </Switch>
              </div>
          </BrowserRouter>
      </div>
    );
  }
}

export default App;
