import React from 'react';
import {
  TextInput,
  View,
} from 'react-native';

export default class RowTemplate extends React.Component {
  render() {
    return (
      <View style={{padding: 10, width: this.props['item.width'], height: this.props['item.height'], backgroundColor: '#AAA13377'}}>
        <TextInput
          style={{ backgroundColor: '#FFFFFF99', flexGrow: 1 }}
          editable={false}
          value={this.props['item.name']}
        />
      </View>
    );
  }
}