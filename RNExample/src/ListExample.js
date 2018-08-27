import React from 'react';
import {
  StyleSheet,
  Text,
  View,
  Dimensions,
} from 'react-native';
import { SynchronousList } from 'react-native-synchronous-list';




const complexDataObj = [];
const itemWidth=Math.trunc(Dimensions.get('window').width/3);
console.log("heeeeyyy item width is "+itemWidth);
for (const i = 0; i < 100; i++) {
  complexDataObj.push({
    name: `https://picsum.photos/1080/1920/?image=${i}`,
    width: itemWidth,
    height: itemWidth,
  })
}

class ListExample extends React.Component {
  componentDidMount() {
  }
  render() {
    return (
      <SynchronousList
          ref={l => {
            this.synchronousList = l;
            setTimeout(() => {
              this.synchronousList.prepareRows();
            }, 50)
            // setInterval(async () => {
            //   const curViewIndex = await this.synchronousList.getCurrentViewIndex();
            //   console.log(`Currently at :${curViewIndex}`);
            // }, 500);
          }}
          style={{ top: 0, width: Dimensions.get('window').width, height: Dimensions.get('window').height, backgroundColor: '#F2F2F2' }}
          templateName={this.props.templateName}
          rowHeight={100}
          dynamicViewSizes
          numRenderRows={10}
          data={complexDataObj}
          colsNum={3}
          loopMode={SynchronousList.LOOP_MODES.NO_LOOP}
        />
    );
  }
}
export default ListExample;