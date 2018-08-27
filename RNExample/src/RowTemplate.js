import React from 'react';
import {
  // TextInput,
    Image,
  Text,
  View,
} from 'react-native';
import { SyncRegistry } from 'react-native-synchronous-list';
import FrescoImageView from './FrescoImage'
const TemplateName = 'MyTemplate';

// const RowTemplate = (props) => (
//   <View style={{padding: 10, width: props.width, height: props.height, backgroundColor: '#AAA13377'}}>
//     <TextInput
//       style={{ backgroundColor: '#FFFFFF99', flexGrow: 1 }}
//       editable={false}
//       value={props.name}
//     />
//   </View>
// );
const RowTemplate = (props) => (
  <View style={{ width: props.width, height: props.height, backgroundColor: '#AAA13377'}}>
   {/* <Text
      style={{ backgroundColor: '#FFFFFF99', flexGrow: 1 }}
      editable={false}
    >
      {props.name}
    </Text>*/}
      <FrescoImageView style={{ flex:1,backgroundColor:'black'}} src={props.name} />
  </View>
);
  
/*
  CAUTION:
    We swizzle react.render so if you try to register a recipe while other components are rendering,
    you will get errors (usually manage children errors)
    ALWAYS register the recipe when react is NOT rendering other components
    (Preferably right when the app launches - and before you render other components!!)
*/
SyncRegistry.registerComponent(TemplateName, () => RowTemplate, ['name','width','height']);

RowTemplate.TemplateName = TemplateName;
export default RowTemplate;