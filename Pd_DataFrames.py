df1 = pd.DataFrame({
	'A': ['A0','A1','A2','A3'],
	'B': ['B0','B1','B2','B3'],
	'C': ['C0','C1','C2','C3'],
	'D': ['D0','D1','D2','D3']
},
index = [0,1,2,3])

df2 = pd.DataFrame({
	'A': ['A4','A5','A6','A7'],
	'B': ['B4','B5','B6','B7'],
	'C': ['C4','C5','C6','C7'],
	'D': ['D4','D5','D6','D7']
},
index = [4,5,6,7])

df3 = pd.DataFrame({
	'A': ['A8','A9','A10','A11'],
	'B': ['B8','B9','B10','B11'],
	'C': ['C8','C9','C10','C11'],
	'D': ['D8','D9','D10','D11']
},
index = [8,9,10,11])

# -----------------

left = pd.DataFrame({
  'key': ['K0','K1','K2','K3'],
	'A': ['A0','A1','A2','A3'],
	'B': ['B0','B1','B2','B3'],
})


left = pd.DataFrame({
  'key': ['K0','K1','K2','K3'],
	'C': ['C0','C1','C2','C3'],
	'D': ['D0','D1','D2','D3']
})

# ------------

left = pd.DataFrame({'key1': ['K0', 'K0', 'K1', 'K2'],
                         'key2': ['K0', 'K1', 'K0', 'K1'],
                            'A': ['A0', 'A1', 'A2', 'A3'],
                            'B': ['B0', 'B1', 'B2', 'B3']})
       
right = pd.DataFrame({'key1': ['K0', 'K1', 'K1', 'K2'],
	                   'key2': ['K0', 'K0', 'K0', 'K0'],
	                      'C': ['C0', 'C1', 'C2', 'C3'],
	                      'D': ['D0', 'D1', 'D2', 'D3']})


# ----------

left3 = pd.DataFrame({'A': ['A0', 'A1', 'A2'],
                         'B': ['B0', 'B1', 'B2']},
                          index=['K0', 'K1', 'K2'])
right3 = pd.DataFrame({'C': ['C0', 'C2', 'C3'],
                    'D': ['D0', 'D2', 'D3']},
                      index=['K0', 'K2', 'K3'])

# ----------

import pandas as pd
df = pd.DataFrame({'col1':[1,2,3,4],'col2':[444,555,666,444],'col3':['abc','def','ghi','xyz']})
df.head()

# ---------
data = {'A':['foo','foo','foo','bar','bar','bar'],
	   'B':['one','one','two','two','one','one'],
	   'C':['x','y','x','y','x','y'],
	   'D':[1,3,2,5,4,1]}