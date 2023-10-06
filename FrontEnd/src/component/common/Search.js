import React from 'react'

const Search = ({search , setSearch}) => {
  return (
    <div className='col-sm-6 mb-4'>
        <form onSubmit={(e)=> e.preventDefault()}>
            <input type='search' role='searchbox' placeholder='Search Students' value={search} onChange={(e) => setSearch(e.target.value)} className='form-control'></input>
        </form>
      
    </div>
  )
}

export default Search