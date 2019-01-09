import React, {Component} from 'react';
import {SERVER_URL} from '../constants.js';

//TODO: This can fetch the recipies
// Will need to research about how I want to display the
// list of recipes.
class Recipes extends Component {

    constructor(props) {
        super(props);
        this.state = {recipes: []}
    }

    componentDidMount() {
        this.fetchRecipes();
    }

    fetchRecipes() {
        fetch(SERVER_URL + "recipes")
            .then(response => response.json())
            .then(responseData => {
                this.setState({
                        recipes: responseData
                });
            })
            .catch(err => console.error(err));
    }

    render() {

        const tableRows = this.state.recipes.map((recipe, index) =>
            <tr key={index}>
                <td>{recipe.name}</td>
                <td>{recipe.link}</td>
                <td>{recipe.notes}</td>
                <td>{recipe.isFavorite}</td>
            </tr>
        );
        return(
            <div className="App">
                <table>
                    <tbody>{tableRows}</tbody>
                </table>
            </div>
        );
    }
}

export default Recipes;